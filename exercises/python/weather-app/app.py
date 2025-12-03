"""
Weather App - A Flask-based weather application.
Exercise project for Gemini CLI training.
"""

from flask import Flask, jsonify, request
from datetime import datetime
import random

app = Flask(__name__)

# Simulated weather data (in a real app, this would come from an API)
CITIES = {
    "new_york": {"name": "New York", "lat": 40.7128, "lon": -74.0060},
    "london": {"name": "London", "lat": 51.5074, "lon": -0.1278},
    "tokyo": {"name": "Tokyo", "lat": 35.6762, "lon": 139.6503},
    "sydney": {"name": "Sydney", "lat": -33.8688, "lon": 151.2093},
    "paris": {"name": "Paris", "lat": 48.8566, "lon": 2.3522},
}

CONDITIONS = ["sunny", "cloudy", "rainy", "partly_cloudy", "stormy", "snowy"]


def generate_weather(city_id):
    """Generate simulated weather data for a city."""
    if city_id not in CITIES:
        return None

    city = CITIES[city_id]
    return {
        "city": city["name"],
        "location": {"lat": city["lat"], "lon": city["lon"]},
        "temperature": {
            "current": round(random.uniform(0, 35), 1),
            "feels_like": round(random.uniform(0, 35), 1),
            "min": round(random.uniform(-5, 15), 1),
            "max": round(random.uniform(20, 40), 1),
        },
        "condition": random.choice(CONDITIONS),
        "humidity": random.randint(30, 90),
        "wind_speed": round(random.uniform(0, 50), 1),
        "timestamp": datetime.now().isoformat(),
    }


@app.route("/")
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


@app.route("/cities")
def list_cities():
    """List all available cities."""
    return jsonify({
        "cities": [
            {"id": city_id, "name": city["name"]}
            for city_id, city in CITIES.items()
        ]
    })


@app.route("/weather/<city_id>")
def get_weather(city_id):
    """Get current weather for a specific city."""
    city_id = city_id.lower().replace(" ", "_")
    weather = generate_weather(city_id)

    if weather is None:
        return jsonify({"error": "City not found"}), 404

    return jsonify(weather)


@app.route("/forecast/<city_id>")
def get_forecast(city_id):
    """Get 5-day weather forecast for a city."""
    # TODO: Implement forecast functionality
    return jsonify({"error": "Not implemented yet"}), 501


if __name__ == "__main__":
    app.run(debug=True, port=5000)
