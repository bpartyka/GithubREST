package pl.demo.github.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.HttpClientErrorException;
import pl.demo.github.model.GithubRepositoryDetails;
import pl.demo.github.repository.GithubRestClient;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertTrue;

@AutoConfigureMockMvc
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class RepositoryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private GithubRestClient githubRestClientMock;

    @Test
    public void shouldReturnRepositoryDetails() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.ENGLISH);
        Date resultTime = formatter.parse("2020-08-31T19:26:51.588+00:00");
        ResponseEntity<GithubRepositoryDetails> responseEntity = ResponseEntity
                .ok()
                .body(new GithubRepositoryDetails("owner/name", "desc", "url", 2, resultTime));

        Mockito.when(githubRestClientMock.getGithubRepositoryDetails("owner", "name")).thenReturn(responseEntity);

        mockMvc.perform(MockMvcRequestBuilders.get("/repositories/owner/name"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .json("{\n" +
                                "    \"fullName\": \"owner/name\",\n" +
                                "    \"description\": desc,\n" +
                                "    \"cloneUrl\": \"url\",\n" +
                                "    \"stars\": 2,\n" +
                                "    \"createdAt\": \"2020-08-31T19:26:51.588+00:00\"\n" +
                                "}")
                );
    }

    @Test
    public void shouldReturnNotFoundStatusWhenGithubReturns404() throws Exception {
        Mockito.when(githubRestClientMock.getGithubRepositoryDetails("owner", "name")).thenThrow(HttpClientErrorException.NotFound.class);

        mockMvc.perform(MockMvcRequestBuilders.get("/repositories/owner/name"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof HttpClientErrorException.NotFound));
    }

}