import requests
import urllib.parse

geocode_url = "https://graphhopper.com/api/1/geocode?"
route_url = "https://graphhopper.com/api/1/route?"
loc1 = "Washington, D.C."
loc2 = "Baltimore, Maryland"
key = "351dad66-c62c-476a-ace8-a01b64c4f689"

url = geocode_url + urllib.parse.urlencode({
    "q": loc1,
    "limit": "1",
    "key": key
})

replydata = requests.get(url, timeout=20)
json_data = replydata.json()
json_status = replydata.status_code
print(json_data)
