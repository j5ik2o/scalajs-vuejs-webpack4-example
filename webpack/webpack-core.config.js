var path = require("path");
var CopyWebpackPlugin = require('copy-webpack-plugin');
var HtmlWebpackPlugin = require('html-webpack-plugin');
var VueLoaderPlugin = require('vue-loader/lib/plugin');

module.exports = {
  mode: "development",
  resolve: {
    alias: {
      "resources": path.resolve(__dirname, "../../../../src/main/resources"),
      "js": path.resolve(__dirname, "../../../../src/main/js"),
      "scalajs": path.resolve(__dirname, "./scalajs-entry.js"),
      'vue$': 'vue/dist/vue.esm.js'
    },
    modules: [ path.resolve(__dirname, 'node_modules') ]
  },
  module: {
    rules: [
      {
        test: /\.vue$/,
        loader: 'vue-loader',
         // options: vueLoaderConfig
      },
      {
        test: /\.css$/,
        use: [ 'vue-style-loader', 'style-loader', 'css-loader' ]
      },
      // "file" loader for svg
      {
        test: /\.svg$/,
        use: [
          {
            loader: 'file-loader',
            query: {
              name: 'static/media/[name].[hash:8].[ext]'
            }
          }
        ]
      }
    ]
  },
  plugins: [
    new VueLoaderPlugin(),
    new CopyWebpackPlugin([
      { from: path.resolve(__dirname, "../../../../public") }
    ]),
    new HtmlWebpackPlugin({
      template: path.resolve(__dirname, "../../../../public/index.html"),
      inject: "head"
    })
  ],
  output: {
    devtoolModuleFilenameTemplate: (f) => {
      if (f.resourcePath.startsWith("http://") ||
          f.resourcePath.startsWith("https://") ||
          f.resourcePath.startsWith("file://")) {
        return f.resourcePath;
      } else {
        return "webpack://" + f.namespace + "/" + f.resourcePath;
      }
    }
  }
}
