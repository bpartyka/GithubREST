package pl.demo.github.model.mapper;

import org.modelmapper.ModelMapper;
import pl.demo.github.model.GithubRepositoryDetails;
import pl.demo.github.model.RepositoryDetails;

public class GithubMapper {

    private GithubMapper() {}

    public static RepositoryDetails mapToRepository(GithubRepositoryDetails githubRepositoryDetails) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(githubRepositoryDetails, RepositoryDetails.class);
    }
}
