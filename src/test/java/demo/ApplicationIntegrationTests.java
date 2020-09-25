package demo;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import demo.model.RepositoryDetails;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationIntegrationTests {

    @LocalServerPort
    private Integer port;

    @Test
    public void shouldReturnRepositoryDetails() throws ParseException {
        WireMockServer wireMockServer = new WireMockServer();

        wireMockServer.start();
        configureFor("localhost", 8080);

        stubFor(get("https://api.github.com/repos/bpartyka/CSVSpringApp")
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody(
                                "{\n" +
                                        "    \"id\": 291511087,\n" +
                                        "    \"node_id\": \"MDEwOlJlcG9zaXRvcnkyOTE1MTEwODc=\",\n" +
                                        "    \"name\": \"CSVSpringApp\",\n" +
                                        "    \"full_name\": \"bpartyka/CSVSpringApp\",\n" +
                                        "    \"private\": false,\n" +
                                        "    \"owner\": {\n" +
                                        "        \"login\": \"bpartyka\",\n" +
                                        "        \"id\": 37458115,\n" +
                                        "        \"node_id\": \"MDQ6VXNlcjM3NDU4MTE1\",\n" +
                                        "        \"avatar_url\": \"https://avatars2.githubusercontent.com/u/37458115?v=4\",\n" +
                                        "        \"gravatar_id\": \"\",\n" +
                                        "        \"url\": \"https://api.github.com/users/bpartyka\",\n" +
                                        "        \"html_url\": \"https://github.com/bpartyka\",\n" +
                                        "        \"followers_url\": \"https://api.github.com/users/bpartyka/followers\",\n" +
                                        "        \"following_url\": \"https://api.github.com/users/bpartyka/following{/other_user}\",\n" +
                                        "        \"gists_url\": \"https://api.github.com/users/bpartyka/gists{/gist_id}\",\n" +
                                        "        \"starred_url\": \"https://api.github.com/users/bpartyka/starred{/owner}{/repo}\",\n" +
                                        "        \"subscriptions_url\": \"https://api.github.com/users/bpartyka/subscriptions\",\n" +
                                        "        \"organizations_url\": \"https://api.github.com/users/bpartyka/orgs\",\n" +
                                        "        \"repos_url\": \"https://api.github.com/users/bpartyka/repos\",\n" +
                                        "        \"events_url\": \"https://api.github.com/users/bpartyka/events{/privacy}\",\n" +
                                        "        \"received_events_url\": \"https://api.github.com/users/bpartyka/received_events\",\n" +
                                        "        \"type\": \"User\",\n" +
                                        "        \"site_admin\": false\n" +
                                        "    },\n" +
                                        "    \"html_url\": \"https://github.com/bpartyka/CSVSpringApp\",\n" +
                                        "    \"description\": null,\n" +
                                        "    \"fork\": false,\n" +
                                        "    \"url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp\",\n" +
                                        "    \"forks_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/forks\",\n" +
                                        "    \"keys_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/keys{/key_id}\",\n" +
                                        "    \"collaborators_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/collaborators{/collaborator}\",\n" +
                                        "    \"teams_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/teams\",\n" +
                                        "    \"hooks_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/hooks\",\n" +
                                        "    \"issue_events_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/issues/events{/number}\",\n" +
                                        "    \"events_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/events\",\n" +
                                        "    \"assignees_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/assignees{/user}\",\n" +
                                        "    \"branches_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/branches{/branch}\",\n" +
                                        "    \"tags_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/tags\",\n" +
                                        "    \"blobs_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/git/blobs{/sha}\",\n" +
                                        "    \"git_tags_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/git/tags{/sha}\",\n" +
                                        "    \"git_refs_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/git/refs{/sha}\",\n" +
                                        "    \"trees_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/git/trees{/sha}\",\n" +
                                        "    \"statuses_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/statuses/{sha}\",\n" +
                                        "    \"languages_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/languages\",\n" +
                                        "    \"stargazers_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/stargazers\",\n" +
                                        "    \"contributors_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/contributors\",\n" +
                                        "    \"subscribers_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/subscribers\",\n" +
                                        "    \"subscription_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/subscription\",\n" +
                                        "    \"commits_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/commits{/sha}\",\n" +
                                        "    \"git_commits_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/git/commits{/sha}\",\n" +
                                        "    \"comments_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/comments{/number}\",\n" +
                                        "    \"issue_comment_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/issues/comments{/number}\",\n" +
                                        "    \"contents_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/contents/{+path}\",\n" +
                                        "    \"compare_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/compare/{base}...{head}\",\n" +
                                        "    \"merges_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/merges\",\n" +
                                        "    \"archive_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/{archive_format}{/ref}\",\n" +
                                        "    \"downloads_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/downloads\",\n" +
                                        "    \"issues_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/issues{/number}\",\n" +
                                        "    \"pulls_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/pulls{/number}\",\n" +
                                        "    \"milestones_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/milestones{/number}\",\n" +
                                        "    \"notifications_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/notifications{?since,all,participating}\",\n" +
                                        "    \"labels_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/labels{/name}\",\n" +
                                        "    \"releases_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/releases{/id}\",\n" +
                                        "    \"deployments_url\": \"https://api.github.com/repos/bpartyka/CSVSpringApp/deployments\",\n" +
                                        "    \"created_at\": \"2020-08-30T16:45:24Z\",\n" +
                                        "    \"updated_at\": \"2020-09-08T22:04:32Z\",\n" +
                                        "    \"pushed_at\": \"2020-09-01T10:14:15Z\",\n" +
                                        "    \"git_url\": \"git://github.com/bpartyka/CSVSpringApp.git\",\n" +
                                        "    \"ssh_url\": \"git@github.com:bpartyka/CSVSpringApp.git\",\n" +
                                        "    \"clone_url\": \"https://github.com/bpartyka/CSVSpringApp.git\",\n" +
                                        "    \"svn_url\": \"https://github.com/bpartyka/CSVSpringApp\",\n" +
                                        "    \"homepage\": null,\n" +
                                        "    \"size\": 60,\n" +
                                        "    \"stargazers_count\": 1,\n" +
                                        "    \"watchers_count\": 1,\n" +
                                        "    \"language\": \"Java\",\n" +
                                        "    \"has_issues\": true,\n" +
                                        "    \"has_projects\": true,\n" +
                                        "    \"has_downloads\": true,\n" +
                                        "    \"has_wiki\": true,\n" +
                                        "    \"has_pages\": false,\n" +
                                        "    \"forks_count\": 0,\n" +
                                        "    \"mirror_url\": null,\n" +
                                        "    \"archived\": false,\n" +
                                        "    \"disabled\": false,\n" +
                                        "    \"open_issues_count\": 0,\n" +
                                        "    \"license\": null,\n" +
                                        "    \"forks\": 0,\n" +
                                        "    \"open_issues\": 0,\n" +
                                        "    \"watchers\": 1,\n" +
                                        "    \"default_branch\": \"master\",\n" +
                                        "    \"temp_clone_token\": null,\n" +
                                        "    \"network_count\": 0,\n" +
                                        "    \"subscribers_count\": 1\n" +
                                        "}"
                        )));

        RestTemplate rt = new RestTemplate();
        ResponseEntity<RepositoryDetails> body = rt.getForEntity("http://localhost:"+ port +"/repositories/bpartyka/CSVSpringApp", RepositoryDetails.class);


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.ENGLISH);
        Date resultTime = formatter.parse("2020-08-30T16:45:24.000+00:00");

        RepositoryDetails expected = new RepositoryDetails(
                "bpartyka/CSVSpringApp",
                null,
                "https://github.com/bpartyka/CSVSpringApp.git",
                1,
                resultTime
        );
        Assertions.assertEquals(expected, body.getBody());

        wireMockServer.stop();
    }

}
