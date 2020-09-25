package pl.demo.github.repository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.demo.github.configuration.RTConfig;
import pl.demo.github.model.GithubRepositoryDetails;

@Service
public class GithubRestClient {
    private static final String URL = "https://api.github.com";

    private final RTConfig rt;

    public GithubRestClient(RTConfig rt) {
        this.rt = rt;
    }

    public ResponseEntity<GithubRepositoryDetails> getGithubRepositoryDetails(String owner, String repoName) {

        String url = URL + "/repos/" + owner + "/" + repoName;
        return rt.getRT().getForEntity(url, GithubRepositoryDetails.class);
    }
}
