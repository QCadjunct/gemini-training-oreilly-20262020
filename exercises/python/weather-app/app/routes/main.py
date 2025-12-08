from flask import Blueprint, jsonify

main_bp = Blueprint('main', __name__)

@main_bp.route("/")
def home():
    """Home endpoint with API documentation."""
    return jsonify({
        "name": "Weather API",
        "version": "1.0.0",
        "endpoints": {
            "/weather/<city>": "Get current weather for a city",
            "/cities": "List available cities",
            "/forecast/<city>": "Get 5-day forecast (TODO)",
        }
    })
