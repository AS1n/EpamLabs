package com.netcracker.edu.backend.lab2.classes;

import com.netcracker.edu.backend.lab2.entity.ResEntity;

import java.util.*;

import static java.util.Arrays.asList;

public class Statistics {

    private Long provided;
    private Long incorrect;
    private ResEntity max;
    private ResEntity min;
    private ResEntity mostPopular;

    private Statistics(Long provided) {
        this.provided = provided;
    }

    public Statistics() {
    }

    public static Statistics setStatistics(ArrayList<ResEntity> entities) {
        Statistics statistics = new Statistics((long) entities.size());
        Comparator<ResEntity> comparator = (ResEntity o1, ResEntity o2) -> {
            if (o1.isEven() != o1.isSimple())
                return 1;
            else return -1;
        };
        statistics.setIncorrect(
                entities
                        .stream()
                        .count()
        );
        statistics.setMin(entities.stream().min(comparator).get());
        statistics.setMax(entities.stream().max(comparator).get());
        statistics.calculateMostPopular(entities);
        return statistics;
    }

    private void calculateMostPopular(ArrayList<ResEntity> entities) {
        Map<ResEntity, Long> map = new HashMap<>();
        entities.stream().distinct().forEach(entity ->
            map.put(entity, entities.stream().filter(entity1 -> entity1.equals(entity)).count()));
        long maxCount = 0;
        this.mostPopular = null;
        for (Map.Entry<ResEntity, Long> entry :
                map.entrySet()) {
            if(entry.getValue()>maxCount) {
                maxCount = entry.getValue();
                this.mostPopular = entry.getKey();
            }
        }
    }

    public void setMostPopular(ArrayList<ResEntity> entities) {
        Map<ResEntity, Integer> map = new HashMap<>(4);
        ArrayList<ResEntity> entAnswers = new ArrayList<>();
        List<Long> answers = asList(0L,0L,0L,0L);

        initCollections(entAnswers, map);
        entities.stream().forEach(entity -> {
            int index = map.get(entity);
            long res = answers.get(index);
            answers.set(index, ++res);
        });
        Integer id = getMaxAns(answers);
        if(id!=null)
            this.mostPopular = entAnswers.get(id);
    }

    private void initCollections(ArrayList<ResEntity> entAnswers, Map<ResEntity, Integer> map) {
        entAnswers.add(new ResEntity(true, true));
        entAnswers.add(new ResEntity(true, false));
        entAnswers.add(new ResEntity(false, true));
        entAnswers.add(new ResEntity(false, false));
        for(int i = 0; i < 4; i++)
            map.put(entAnswers.get(i), i);
    }

    private Integer getMaxAns(List<Long> answers) {
        long maxAns = 0;
        Integer maxAnsId = null;
        for(int i = 0; i < 4; i++) {
            if(answers.get(i)>maxAns) {
                maxAns = answers.get(i);
                maxAnsId = i;
            }
        }
        return maxAnsId;
    }

    public ResEntity getMostPopular() {
        return mostPopular;
    }

    public Long getProvided() {
        return provided;
    }

    public void setProvided(Long provided) {
        this.provided = provided;
    }

    public Long getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(Long incorrect) {
        this.incorrect = incorrect;
    }

    public ResEntity getMax() {
        return max;
    }

    public void setMax(ResEntity max) {
        this.max = max;
    }

    public ResEntity getMin() {
        return min;
    }

    public void setMin(ResEntity min) {
        this.min = min;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "provided=" + provided +
                ", incorrect=" + incorrect +
                ", max=" + max +
                ", min=" + min +
                ", mostPopular=" + mostPopular +
                '}';
    }
}
