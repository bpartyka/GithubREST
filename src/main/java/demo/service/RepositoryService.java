package demo.service;

import demo.model.mapper.GithubMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import demo.model.GithubRepositoryDetails;
import demo.model.RepositoryDetails;
import demo.repository.GithubRestClient;

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
