package pl.demo.github.model.mapper;

import org.junit.jupiter.api.Test;
import pl.demo.github.model.GithubRepositoryDetails;
import pl.demo.github.model.RepositoryDetails;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GithubRestClientMapperTest {

    @Test
    public void shouldMapGithubRepositoryDetailsToRepositoryDetails() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.ENGLISH);
        Date resultTime = formatter.parse("2020-08-31T19:26:51.588+00:00");
        GithubRepositoryDetails githubRepositoryDetails = new GithubRepositoryDetails("fullName", "desc", "url", 3, resultTime);
        RepositoryDetails expected = new RepositoryDetails("fullName", "desc", "url", 3, resultTime);

        RepositoryDetails actual = GithubMapper.mapToRepository(githubRepositoryDetails);

        assertEquals(expected, actual);
    }

}