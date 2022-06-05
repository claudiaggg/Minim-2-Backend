package edu.upc.dsa;

import edu.upc.dsa.models.Item;
import edu.upc.dsa.models.Stats;
import edu.upc.dsa.models.User;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class StatsManagerImpl implements StatsManager{
    private static StatsManager instance;
    protected List<Stats> stats;
    private HashMap<String, Stats> hmStats;
    final static Logger logger = Logger.getLogger(StatsManagerImpl.class);


    private StatsManagerImpl() {
        this.stats = new LinkedList<>();
        hmStats = new HashMap<String, Stats>();
    }

    public static StatsManager getInstance() {
        if (instance == null) instance = new StatsManagerImpl();
        return instance;
    }

    public int size() {
        int ret = this.stats.size();
        logger.info("size " + ret);

        return ret;
    }

    public List<Stats> getRanking()
    {
        stats.add(new Stats("claudia",10, "https://media.istockphoto.com/photos/baby-sheep-close-up-picture-id1164046558?k=20&m=1164046558&s=612x612&w=0&h=zxGnSQ5FUPcLfES4v4tzz4836vepegA8bcevwjnkf0s="));
        stats.add(new Stats("barto",23, "https://i.blogs.es/e32e91/trucos-enfocar-fotografia-paisaje-01/1366_2000.jpg"));
        stats.add(new Stats("nico",8,"https://cdn.pixabay.com/photo/2017/07/11/15/51/kermit-2493979_1280.png"));

        stats.sort(Comparator.comparingDouble(Stats::getPoints).reversed());
        logger.info("Estadisticas cargadas completamente");
        return stats;

    }
}
