package daikon.freemarker

import daikon.core.Response
import daikon.freemarker.Template.DEFAULT_TEMPLATE_FOLDER

fun Response.render(name: String, model: HashMap<String, Any> = hashMapOf(), folder: String = DEFAULT_TEMPLATE_FOLDER) {
    write(Template.render(name, model, folder))
}

fun Response.html(name: String, model: HashMap<String, Any> = hashMapOf(), folder: String = DEFAULT_TEMPLATE_FOLDER) {
    type("text/html;charset=utf-8")
    render(name, model, folder)
}
