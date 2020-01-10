package daikon.freemarker

import daikon.Response
import daikon.freemarker.Template.contentOf
import org.eclipse.jetty.http.MimeTypes

private const val DEFAULT_TEMPLATE_FOLDER = "/templates"

fun Response.render(name: String, model: HashMap<String, Any> = hashMapOf(), folder: String = DEFAULT_TEMPLATE_FOLDER) {
    this.write(contentOf(name, model, folder))
}

fun Response.html(name: String, model: HashMap<String, Any> = hashMapOf(), folder: String = DEFAULT_TEMPLATE_FOLDER) {
    this.type(MimeTypes.Type.TEXT_HTML_UTF_8.asString())
    this.render(name, model, folder)
}
