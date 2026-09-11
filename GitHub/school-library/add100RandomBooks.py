import requests
import json
from faker import Faker

APIHOST = "http://127.0.0.1:5000"
LOGIN = "cisco"
PASSWORD = "Cisco123!"


def getAuthToken():
    authCreds = (LOGIN, PASSWORD)

    r = requests.post(
        f"{APIHOST}/api/v1/loginViaBasic",
        auth=authCreds
    )

    if r.status_code == 200:
        return r.json()["token"]
    else:
        raise Exception(
            f"Status code {r.status_code} and text {r.text}"
        )


def addBook(book, apiKey):
    r = requests.post(
        f"{APIHOST}/api/v1/books",
        headers={
            "Content-Type": "application/json",
            "X-API-Key": apiKey
        },
        data=json.dumps(book)
    )

    if r.status_code == 200:
        print(f"Book {book} added.")
    else:
        raise Exception(
            f"Error code {r.status_code} and text {r.text}"
        )


apiKey = getAuthToken()

fake = Faker()

for i in range(6, 106):
    fakeTitle = fake.catch_phrase()
    fakeAuthor = fake.name()
    fakeISBN = fake.isbn13()

    book = {
        "id": i,
        "title": fakeTitle,
        "author": fakeAuthor,
        "isbn": fakeISBN
    }

    addBook(book, apiKey)