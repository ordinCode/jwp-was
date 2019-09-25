package http.response;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;

class HttpResponseBodyTest {

    @Test
    void getBodyLength() throws IOException, URISyntaxException {
        HttpResponseBody httpResponseBody = new HttpResponseBody("/index.html");
        assertThat(httpResponseBody.getBodyLength()).isEqualTo(6902);
    }
}