package daikon.freemarker

import daikon.Response
import freemarker.template.Configuration
import java.io.StringWriter

object Template {
    fun contentOf(name: String, model: HashMap<String, Any>, folder: String): String {
        val configuration =
            Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS)
        configuration.setClassForTemplateLoading(Response::class.java, folder)

        StringWriter().use {
            configuration.getTemplate("$name.ftl").process(model, it)
            return it.toString()
        }
    }
}