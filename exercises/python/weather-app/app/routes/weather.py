from flask import Blueprint, jsonify
from app.services.weather_service import get_weather_data, get_forecast_data, get_all_cities

weather_bp = Blueprint('weather', __name__)

@weather_bp.route("/cities")
def list_cities():
    """List all available cities."""
    cities = get_all_cities()
    return jsonify({
        "cities": cities
    })


@weather_bp.route("/weather/<city_id>")
def get_weather(city_id):
    """Get current weather for a specific city."""
    weather = get_weather_data(city_id)

    if weather is None:
        return jsonify({"error": "City not found"}), 404

    return jsonify(weather)


@weather_bp.route("/forecast/<city_id>")
def get_forecast(city_id):
    """Get 5-day weather forecast for a city."""
    forecast = get_forecast_data(city_id)
    
    if forecast is None:
        return jsonify({"error": "City not found"}), 404
        
    return jsonify(forecast)
