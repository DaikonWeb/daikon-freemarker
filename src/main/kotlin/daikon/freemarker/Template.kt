package daikon.freemarker

import daikon.core.Response
import freemarker.template.Configuration
import java.io.StringWriter

object Template {
    const val DEFAULT_TEMPLATE_FOLDER = "/templates"

    fun render(name: String, model: HashMap<String, Any> = hashMapOf(), folder: String = DEFAULT_TEMPLATE_FOLDER): String {
        val configuration =
            Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS)
        configuration.setClassForTemplateLoading(Response::class.java, folder)

        StringWriter().use {
            configuration.getTemplate("$name.ftl").process(model, it)
            return it.toString()
        }
    }
}