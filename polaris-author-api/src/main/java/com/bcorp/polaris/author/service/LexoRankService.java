package com.bcorp.polaris.author.service;

public interface LexoRankService
{
    String getInitialRank();

    String getBetweenRank(String prevRank, String nextRank);

    String getPrevRank(String rank);

    String getNextRank(String rank);
}
