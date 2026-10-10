import hashlib
import os
import sqlite3
from flask import Flask, request

app = Flask(__name__)
DB_NAME = os.path.join(os.path.dirname(os.path.abspath(__file__)), "test.db")


def get_db_connection():
    return sqlite3.connect(DB_NAME)


@app.route("/", methods=["GET"])
def index():
    return (
        "Welcome to the hands-on lab for an evolution of password systems!\n"
        "Endpoints: POST /signup/v1, POST /login/v1, "
        "POST /signup/v2, POST /login/v2"
    )


@app.route("/signup/v1", methods=["POST"])
def signup_v1():
    username = request.form.get("username", "").strip()
    password = request.form.get("password", "")
    if not username or not password:
        return "username and password required", 400

    try:
        with get_db_connection() as conn:
            conn.execute(
                """CREATE TABLE IF NOT EXISTS USER_PLAIN
                   (USERNAME TEXT PRIMARY KEY NOT NULL,
                    PASSWORD TEXT NOT NULL)"""
            )
            conn.execute(
                "INSERT INTO USER_PLAIN (USERNAME, PASSWORD) VALUES (?, ?)",
                (username, password),
            )
    except sqlite3.IntegrityError:
        return "username has been registered."


    print(f"[v1 plaintext demo] registered username: {username}")
    return "signup success"


def verify_plain(username, password):
    with get_db_connection() as conn:
        row = conn.execute(
            "SELECT PASSWORD FROM USER_PLAIN WHERE USERNAME = ?", (username,)
        ).fetchone()
    return bool(row) and row[0] == password


@app.route("/login/v1", methods=["GET", "POST"])
def login_v1():
    if request.method != "POST":
        return "Invalid Method"
    username = request.form.get("username", "").strip()
    password = request.form.get("password", "")
    if verify_plain(username, password):
        return "login success"
    return "Invalid username/password"


def sha256_password(password):
    """SHA-256 without salt, matching the lab's demonstration only."""
    return hashlib.sha256(password.encode("utf-8")).hexdigest()


@app.route("/signup/v2", methods=["POST"])
def signup_v2():
    username = request.form.get("username", "").strip()
    password = request.form.get("password", "")
    if not username or not password:
        return "username and password required", 400

    hash_value = sha256_password(password)
    try:
        with get_db_connection() as conn:
            conn.execute(
                """CREATE TABLE IF NOT EXISTS USER_HASH
                   (USERNAME TEXT PRIMARY KEY NOT NULL,
                    HASH TEXT NOT NULL)"""
            )
            conn.execute(
                "INSERT INTO USER_HASH (USERNAME, HASH) VALUES (?, ?)",
                (username, hash_value),
            )
    except sqlite3.IntegrityError:
        return "username has been registered."

    print(f"[v2 hash demo] registered username: {username}; hash: {hash_value}")
    return "signup success"


def verify_hash(username, password):
    with get_db_connection() as conn:
        row = conn.execute(
            "SELECT HASH FROM USER_HASH WHERE USERNAME = ?", (username,)
        ).fetchone()
    return bool(row) and row[0] == sha256_password(password)


@app.route("/login/v2", methods=["GET", "POST"])
def login_v2():
    if request.method != "POST":
        return "Invalid Method"
    username = request.form.get("username", "").strip()
    password = request.form.get("password", "")
    if verify_hash(username, password):
        return "login success"
    return "Invalid username/password"


if __name__ == "__main__":
    print(f"SQLite database: {DB_NAME}")
    print("Local lab server: http://127.0.0.1:5000/")
    print("Press Ctrl+C to stop the server.")
    app.run(host="127.0.0.1", port=5000, debug=False)
