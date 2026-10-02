from flask import Flask, request, render_template

sample = Flask(__name__)

@sample.route("/")
def main():
    return render_template("index.html", remote_addr=request.remote_addr)

if __name__ == "__main__":
    sample.run(host="0.0.0.0", port=5050)
