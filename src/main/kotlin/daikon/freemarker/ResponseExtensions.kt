package daikon.freemarker

import daikon.core.Response
import daikon.freemarker.Template.DEFAULT_TEMPLATE_FOLDER
import org.eclipse.jetty.http.MimeTypes

fun Response.render(name: String, model: HashMap<String, Any> = hashMapOf(), folder: String = DEFAULT_TEMPLATE_FOLDER) {
    write(Template.render(name, model, folder))
}

fun Response.html(name: String, model: HashMap<String, Any> = hashMapOf(), folder: String = DEFAULT_TEMPLATE_FOLDER) {
    type(MimeTypes.Type.TEXT_HTML_UTF_8.asString())
    render(name, model, folder)
}
