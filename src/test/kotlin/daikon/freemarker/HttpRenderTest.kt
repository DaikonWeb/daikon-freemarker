package daikon.freemarker

import daikon.HttpServer
import org.assertj.core.api.Assertions.assertThat
import org.eclipse.jetty.http.MimeTypes.Type.TEXT_HTML_UTF_8
import org.junit.jupiter.api.Test
import topinambur.http

class HttpRenderTest {

    @Test
    fun `render a template`() {
        HttpServer()
            .get("/") { _, res -> res.render("hello") }
            .start().use {
                assertThat("http://localhost:4545/".http.get().body).isEqualTo("hello world")
            }
    }

    @Test
    fun `fill template with model`() {
        HttpServer()
            .get("/") { _, res -> res.render("hello_to", hashMapOf("name" to "Bob")) }
            .start().use {
                assertThat("http://localhost:4545/".http.get().body).isEqualTo("hello Bob")
            }
    }

    @Test
    fun `render HTML`() {
        HttpServer()
            .get("/") { _, res -> res.html("hello_to", hashMapOf("name" to "Bob")) }
            .start().use {
                val response = "http://localhost:4545/".http.get()
                assertThat(response.header("Content-Type")).isEqualTo(TEXT_HTML_UTF_8.asString())
                assertThat(response.body).isEqualTo("hello Bob")
            }
    }
}
