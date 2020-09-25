package pl.demo.github.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.demo.github.model.GithubRepositoryDetails;
import pl.demo.github.model.RepositoryDetails;
import pl.demo.github.model.mapper.GithubMapper;
import pl.demo.github.repository.GithubRestClient;

@Service
public class RepositoryService {

    private final GithubRestClient githubRestClient;

    public RepositoryService(GithubRestClient githubRestClient) {
        this.githubRestClient = githubRestClient;
    }

    public RepositoryDetails getRepositoryDetails(String owner, String repoName) {
        ResponseEntity<GithubRepositoryDetails> githubResponse = githubRestClient.getGithubRepositoryDetails(owner, repoName);
        return GithubMapper.mapToRepository(githubResponse.getBody());
    }

}
