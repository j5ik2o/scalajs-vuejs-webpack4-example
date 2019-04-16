package example
import example.components.HelloWorld
import scalajs.vue.{Vue, VueRouter}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel

object VueApp {

  @JSExportTopLevel("main")
  def main(): Unit  = {
    // Vue.config.productionTip = false

    Vue.use(VueRouter)

    val router = new VueRouter(
      js.Dynamic.literal(
        routes = js.Array(
          js.Dynamic.literal(
            path = "/",
            name = "Hello World",
            component = HelloWorld
          )
        )
      )
    )
    /* eslint-disable no-new */
    new Vue(
      js.Dynamic.literal(
        el = "#app",
        router = router,
        components = App,
        template = "<App/>"
      )
    )
  }
}
