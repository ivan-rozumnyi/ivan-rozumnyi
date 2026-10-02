import requests
import urllib.parse

route_url = "https://graphhopper.com/api/1/route?"
key = "351dad66-c62c-476a-ace8-a01b64c4f689"

def geocoding(location, key):
    while location.strip() == "":
        location = input("Enter location again: ")

    geocode_url = "https://graphhopper.com/api/1/geocode?"
    url = geocode_url + urllib.parse.urlencode({
        "q": location,
        "limit": "1",
        "key": key
    })

    try:
        replydata = requests.get(url, timeout=20)
        json_status = replydata.status_code
        json_data = replydata.json()
    except requests.RequestException as exc:
        return 0, "null", "null", location, str(exc)
    except ValueError:
        return 0, "null", "null", location, "API returned non-JSON data"

    if json_status == 200 and len(json_data.get("hits", [])) != 0:
        hit = json_data["hits"][0]
        lat = hit["point"]["lat"]
        lng = hit["point"]["lng"]
        name = hit.get("name", location)
        value = hit.get("osm_value", "")

        country = hit.get("country", "")
        state = hit.get("state", "")

        if state and country:
            new_loc = name + ", " + state + ", " + country
        elif country:
            new_loc = name + ", " + country
        else:
            new_loc = name

        print("Geocoding API URL for " + new_loc +
              " (Location Type: " + value + ")\n" + url)
        return json_status, lat, lng, new_loc, ""
    else:
        lat = "null"
        lng = "null"
        new_loc = location
        message = json_data.get("message", "")
        return json_status, lat, lng, new_loc, message

while True:
    loc1 = input("Starting Location: ")
    if loc1 == "quit" or loc1 == "q":
        break

    orig = geocoding(loc1, key)
    if orig[0] != 200:
        print("Geocode API status: " + str(orig[0]))
        if orig[4]:
            print("Error message: " + orig[4])
        continue

    loc2 = input("Destination: ")
    if loc2 == "quit" or loc2 == "q":
        break

    dest = geocoding(loc2, key)
    if dest[0] != 200:
        print("Geocode API status: " + str(dest[0]))
        if dest[4]:
            print("Error message: " + dest[4])
        continue

    print("=================================================")
    op = "&point=" + str(orig[1]) + "%2C" + str(orig[2])
    dp = "&point=" + str(dest[1]) + "%2C" + str(dest[2])

    paths_url = route_url + urllib.parse.urlencode({"key": key}) + op + dp

    try:
        path_reply = requests.get(paths_url, timeout=20)
        paths_status = path_reply.status_code
        paths_data = path_reply.json()
    except requests.RequestException as exc:
        print("Routing API status: 0")
        print("Error message: " + str(exc))
        print("*************************************************")
        continue
    except ValueError:
        print("Routing API status: " + str(path_reply.status_code))
        print("Error message: API returned non-JSON data")
        print("*************************************************")
        continue

    print("Routing API Status: " + str(paths_status) +
          "\nRouting API URL:\n" + paths_url)

    print("=================================================")
    print("Directions from " + orig[3] + " to " + dest[3])
    print("=================================================")

    if paths_status == 200 and paths_data.get("paths"):
        miles = paths_data["paths"][0]["distance"] / 1000 / 1.61
        km = paths_data["paths"][0]["distance"] / 1000
        sec = int(paths_data["paths"][0]["time"] / 1000 % 60)
        minute = int(paths_data["paths"][0]["time"] / 1000 / 60 % 60)
        hour = int(paths_data["paths"][0]["time"] / 1000 / 60 / 60)

        print("Distance Traveled: {0:.1f} miles / {1:.1f} km".format(miles, km))
        print("Trip Duration: {0:02d}:{1:02d}:{2:02d}".format(hour, minute, sec))
        print("=================================================")

        for each in range(len(paths_data["paths"][0]["instructions"])):
            path = paths_data["paths"][0]["instructions"][each]["text"]
            distance = paths_data["paths"][0]["instructions"][each]["distance"]
            print("{0} ( {1:.1f} km / {2:.1f} miles )".format(
                path, distance / 1000, distance / 1000 / 1.61))

        print("=================================================")
    else:
        print("Error message: " +
              paths_data.get("message", "Connection between locations not found"))
        print("*************************************************")
