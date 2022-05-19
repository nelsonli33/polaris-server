package com.bcorp.polaris.author.service.impl;

import com.bcorp.polaris.author.service.LexoRankService;
import com.github.pravin.raha.lexorank4j.LexoRank;
import org.springframework.stereotype.Service;

import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNullStandardMessage;

@Service(value = "lexiRankService")
public class DefaultLexoRankService implements LexoRankService
{
    public String getInitialRank()
    {
        return LexoRank.middle().toString();
    }

    @Override
    public String getBetweenRank(String prevRank, String nextRank)
    {
        validateParameterNotNullStandardMessage("prevRank", prevRank);
        validateParameterNotNullStandardMessage("nextRank", nextRank);

        final LexoRank prev = LexoRank.parse(prevRank);
        final LexoRank next = LexoRank.parse(nextRank);
        return prev.between(next).toString();
    }

    public String getPrevRank(String rank)
    {
        validateParameterNotNullStandardMessage("rank", rank);

        final LexoRank nextRank = LexoRank.parse(rank);
        return nextRank.genPrev().toString();
    }

    public String getNextRank(String rank)
    {
        validateParameterNotNullStandardMessage("rank", rank);
        
        final LexoRank previousRank = LexoRank.parse(rank);
        return previousRank.genNext().toString();
    }
}
