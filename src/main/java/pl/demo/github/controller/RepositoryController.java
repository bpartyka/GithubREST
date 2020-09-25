package pl.demo.github.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.demo.github.model.RepositoryDetails;
import pl.demo.github.service.RepositoryService;

@RestController
public class RepositoryController {

    private final RepositoryService repositoryService;

    public RepositoryController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @GetMapping("/repositories/{owner}/{repository-name}")
    public RepositoryDetails getRepositoryDetails(@PathVariable("owner") String owner, @PathVariable("repository-name") String repoName) {
        return repositoryService.getRepositoryDetails(owner, repoName);
    }
}
