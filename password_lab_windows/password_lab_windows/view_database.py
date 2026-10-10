import os
import sqlite3

DB_NAME = os.path.join(os.path.dirname(os.path.abspath(__file__)), "test.db")

if not os.path.exists(DB_NAME):
    print("Database not found yet. Start the app and run test_lab.ps1 first.")
    raise SystemExit(0)

with sqlite3.connect(DB_NAME) as conn:
    for table in ("USER_PLAIN", "USER_HASH"):
        exists = conn.execute(
            "SELECT 1 FROM sqlite_master WHERE type='table' AND name=?", (table,)
        ).fetchone()
        print(f"\n=== {table} ===")
        if not exists:
            print("(table not created yet)")
            continue
        rows = conn.execute(f"SELECT * FROM {table} ORDER BY USERNAME").fetchall()
        if not rows:
            print("(no rows)")
        for row in rows:
            print(" | ".join(str(value) for value in row))

print("\nNote: USER_PLAIN contains visible passwords by design for this lab.")
print("USER_HASH contains SHA-256 hashes without salt, also only for demonstration.")
