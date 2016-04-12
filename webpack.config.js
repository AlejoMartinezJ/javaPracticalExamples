module.exports = {
  context: __dirname + '/webapp',
  entry: './app.js',
  output: {
    path: __dirname + '/webapp/build',
    filename: 'bundle.js'
  },
    module: {
        loaders: [
            { test: /\.css$/, loader: 'style!css' },
            { test: /\.html$/, loader: 'html-loader'},
            { test: /\.png/, loader: 'file'},
            { test: /\.jpg/, loader: 'file'},
            { test: /\.eot/, loader: 'file'},
            { test: /\.ttf/, loader: 'file'},
            { test: /\.woff/, loader: 'file'},
            { test: /\.svg/, loader: 'file'}
        ]
  }
};
