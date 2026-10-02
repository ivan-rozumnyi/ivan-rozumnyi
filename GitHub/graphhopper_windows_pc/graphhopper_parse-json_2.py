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

loc1 = "Washington, D.C."
loc2 = "Baltimore, Maryland"

orig = geocoding(loc1, key)
print(orig[:4])

dest = geocoding(loc2, key)
print(dest[:4])
