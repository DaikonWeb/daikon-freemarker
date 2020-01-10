package daikon.freemarker

import daikon.HttpServer
import khttp.get
import org.assertj.core.api.Assertions.assertThat
import org.eclipse.jetty.http.MimeTypes.Type.TEXT_HTML_UTF_8
import org.junit.jupiter.api.Test

class HttpRenderTest {

    @Test
    fun `render a template`() {
        HttpServer()
            .get("/") { _, res -> res.render("hello") }
            .start().use {
                assertThat(get("http://localhost:4545/").text).isEqualTo("hello world")
            }
    }

    @Test
    fun `fill template with model`() {
        HttpServer()
            .get("/") { _, res -> res.render("hello_to", hashMapOf("name" to "Bob")) }
            .start().use {
                assertThat(get("http://localhost:4545/").text).isEqualTo("hello Bob")
            }
    }

    @Test
    fun `render HTML`() {
        HttpServer()
            .get("/") { _, res -> res.html("hello_to", hashMapOf("name" to "Bob")) }
            .start().use {
                val response = get("http://localhost:4545/")
                assertThat(response.headers["Content-Type"]).isEqualTo(TEXT_HTML_UTF_8.asString())
                assertThat(response.text).isEqualTo("hello Bob")
            }
    }
}
