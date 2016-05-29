var path = require('path');
var node_modules = path.resolve(__dirname, 'node_modules');

var config = {
    entry: path.resolve(__dirname, 'src/main/webapp/js/app.jsx'),
    output: {
        path: path.resolve(__dirname, 'src/main/webapp/build'),
        filename: 'bundle.js'
    },
    module: {
        loaders: [
            {
                test: /\.jsx?$/,
                exclude: /node_modules/,
                loader: 'babel-loader',
                query: {
                    presets: ['es2015', 'react']
                }
            }
        ]
    }
};

module.exports = config;