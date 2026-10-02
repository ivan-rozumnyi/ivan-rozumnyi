from flask import Flask, request, jsonify
from functools import wraps
import base64

app = Flask(__name__)

books = [
    {
        "id": 0,
        "title": "IP Routing Fundamentals",
        "author": "Mark A. Sportack",
        "isbn": "978-1578700714"
    },
    {
        "id": 1,
        "title": "Python for Dummies",
        "author": "Stef Maruch Aahz Maruch",
        "isbn": "978-0471778646"
    },
    {
        "id": 2,
        "title": "Linux for Networkers",
        "author": "Cisco Systems Inc.",
        "isbn": "000-0000000123"
    },
    {
        "id": 3,
        "title": "NetAcad: 20 Years Of Online-Learning",
        "author": "Cisco Systems Inc.",
        "isbn": "000-0000001123"
    }
]

API_TOKEN = "cisco|lab-token-123"


def check_api_key():
    return request.headers.get("X-API-KEY") == API_TOKEN


@app.route("/api/v1/books", methods=["GET"])
def get_books():
    result = books.copy()

    include_isbn = request.args.get("includeISBN", "false").lower() == "true"
    sort_by = request.args.get("sortBy", "id")
    author = request.args.get("author")

    if author:
        result = [
            book for book in result
            if book["author"].lower() == author.lower()
        ]

    if sort_by in ["id", "title", "author"]:
        result.sort(key=lambda x: x[sort_by])

    if not include_isbn:
        result = [
            {
                "id": book["id"],
                "title": book["title"],
                "author": book["author"]
            }
            for book in result
        ]

    return jsonify(result), 200


@app.route("/api/v1/books/<int:book_id>", methods=["GET"])
def get_book(book_id):
    for book in books:
        if book["id"] == book_id:
            return jsonify({
                "id": book["id"],
                "title": book["title"],
                "author": book["author"]
            }), 200

    return jsonify({"error": "Book not found"}), 404


@app.route("/api/v1/books", methods=["POST"])
def add_book():
    if not check_api_key():
        return jsonify({"error": "Invalid API key"}), 401

    data = request.get_json()

    if not data:
        return jsonify({"error": "Invalid JSON"}), 400

    required = ["id", "title", "author"]

    for field in required:
        if field not in data:
            return jsonify({"error": f"Missing field: {field}"}), 400

    books.append(data)

    return jsonify(data), 200


@app.route("/api/v1/books/<int:book_id>", methods=["DELETE"])
def delete_book(book_id):
    if not check_api_key():
        return jsonify({"error": "Invalid API key"}), 401

    for i, book in enumerate(books):
        if book["id"] == book_id:
            deleted = books.pop(i)
            return jsonify(deleted), 200

    return jsonify({"error": "Book not found"}), 404


@app.route("/api/v1/loginViaBasic", methods=["POST"])
def login():
    auth = request.authorization

    if not auth:
        return jsonify({"error": "Authentication required"}), 401

    if auth.username == "cisco" and auth.password == "Cisco123!":
        return jsonify({"token": API_TOKEN}), 200

    return jsonify({"error": "Invalid username or password"}), 401


@app.route("/")
def home():
    return jsonify({
        "name": "School Library API",
        "status": "running"
    })


if __name__ == "__main__":
    app.run(host="127.0.0.1", port=5000, debug=True)