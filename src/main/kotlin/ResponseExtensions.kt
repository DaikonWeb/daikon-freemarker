import daikon.Response
import freemarker.template.Configuration
import freemarker.template.Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS
import org.eclipse.jetty.http.MimeTypes
import java.io.File
import java.io.StringWriter

private const val DEFAULT_TEMPLATE_FOLDER = "/templates"

fun Response.render(name: String, model: HashMap<String, Any> = hashMapOf(), folder: String = DEFAULT_TEMPLATE_FOLDER) {
    this.write(contentOf(name, model, folder))
}

fun Response.html(name: String, model: HashMap<String, Any> = hashMapOf(), folder: String = DEFAULT_TEMPLATE_FOLDER) {
    this.type(MimeTypes.Type.TEXT_HTML_UTF_8.asString())
    this.render(name, model, folder)
}

private fun contentOf(name: String, model: HashMap<String, Any>, folder: String): String {
    val configuration = Configuration(DEFAULT_INCOMPATIBLE_IMPROVEMENTS)
    configuration.setClassForTemplateLoading(Response::class.java, folder)

    StringWriter().use {
        configuration.getTemplate("$name.ftl").process(model, it)
        return it.toString()
    }
}