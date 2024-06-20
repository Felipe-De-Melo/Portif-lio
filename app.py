from flask import Flask, request, jsonify, render_template

app = Flask(__name__)

# Funções de conversão
def celsius_to_fahrenheit(celsius):
    return celsius * 9/5 + 32

def celsius_to_kelvin(celsius):
    return celsius + 273.15

def usd_to_brl(usd):
    return usd * 5.5

def eur_to_brl(eur):
    return eur * 5.9

# Endpoints REST
@app.route('/convert/celsius-to-fahrenheit', methods=['GET'])
def convert_celsius_to_fahrenheit():
    celsius = float(request.args.get('celsius'))
    fahrenheit = celsius_to_fahrenheit(celsius)
    return jsonify({'celsius': celsius, 'fahrenheit': fahrenheit})

@app.route('/convert/celsius-to-kelvin', methods=['GET'])
def convert_celsius_to_kelvin():
    celsius = float(request.args.get('celsius'))
    kelvin = celsius_to_kelvin(celsius)
    return jsonify({'celsius': celsius, 'kelvin': kelvin})

@app.route('/convert/usd-to-brl', methods=['GET'])
def convert_usd_to_brl():
    usd = float(request.args.get('usd'))
    brl = usd_to_brl(usd)
    return jsonify({'usd': usd, 'brl': brl})

@app.route('/convert/eur-to-brl', methods=['GET'])
def convert_eur_to_brl():
    eur = float(request.args.get('eur'))
    brl = eur_to_brl(eur)
    return jsonify({'eur': eur, 'brl': brl})

# Página inicial para testar os endpoints
@app.route('/')
def home():
    return render_template('index.html')

if __name__ == '__main__':
    app.run(debug=True)
