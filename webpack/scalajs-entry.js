if (process.env.NODE_ENV === "production") {
    const opt = require("./scalajs-vuejs-webpack4-example-opt.js");
    opt.main();
    module.exports = opt;
} else {
    var exports = window;
    exports.require = require("./scalajs-vuejs-webpack4-example-fastopt-entrypoint.js").require;
    window.global = window;

    const fastOpt = require("./scalajs-vuejs-webpack4-example-fastopt.js");
    fastOpt.main()
    module.exports = fastOpt;

    if (module.hot) {
        module.hot.accept();
    }
}
