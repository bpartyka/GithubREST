package demo.model.mapper;

import org.modelmapper.ModelMapper;
import demo.model.GithubRepositoryDetails;
import demo.model.RepositoryDetails;

public class GithubMapper {

    private GithubMapper() {}

    public static RepositoryDetails mapToRepository(GithubRepositoryDetails githubRepositoryDetails) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(githubRepositoryDetails, RepositoryDetails.class);
    }
}
