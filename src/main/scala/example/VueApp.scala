package example
import example.views.{About, Home}
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
            name = "home",
            component = Home
          ),
          js.Dynamic.literal(
            path = "/about",
            name = "about",
            component = About
          )
        )
      )
    )
    /* eslint-disable no-new */
    new Vue(
      js.Dynamic.literal(
        router = router,
        render = { h: js.Function1[js.Any, js.Any] => h(App)}
      )
    ).$mount("#app")
  }
}
