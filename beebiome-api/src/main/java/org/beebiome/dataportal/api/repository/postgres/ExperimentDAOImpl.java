package org.beebiome.dataportal.api.repository.postgres;

import org.beebiome.dataportal.api.repository.dao.ExperimentDAO;
import org.beebiome.dataportal.api.repository.dt.ExperimentTO;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class ExperimentDAOImpl implements ExperimentDAO {

    NamedParameterJdbcTemplate template;

    public ExperimentDAOImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void insert(ExperimentTO to) {
        final String sql = "insert into experiment(sraAcc, title, platform, " +
                "libraryStrategy, libraryLayout, librarySource)" +
                " values(:sraAcc, :title, :biosampleAcc, :platform," +
                " :libraryStrategy, :libraryLayout, :librarySource)";

        KeyHolder holder = new GeneratedKeyHolder();

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("sraAcc", to.getSraAcc())
                .addValue("title", to.getTitle())
                .addValue("platform", to.getPlatform())
                .addValue("libraryStrategy", to.getLibraryStrategy())
                .addValue("libraryLayout", to.getLibraryLayout())
                .addValue("librarySource", to.getLibrarySource());

        template.update(sql, param, holder);
    }
}
