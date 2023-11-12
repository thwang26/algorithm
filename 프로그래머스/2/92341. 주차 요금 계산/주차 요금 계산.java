import java.util.*;

class Solution {
    static int baseTime;
    static int baseFee;
    static int unitTime;
    static int feePerUnitTime;
    static final int LAST_TIME = 1439;
    Map<String, Integer> recordsMap = new HashMap<>();
    List<Integer> result = new ArrayList<>();

    public int[] solution(int[] fees, String[] records) {
        baseTime = fees[0];
        baseFee = fees[1];
        unitTime = fees[2];
        feePerUnitTime = fees[3];

        calculateTime(records); // 주차시간 계산
        calculateFees(); // 주차시간에 따른 요금 계산

        return getAnswer(result);
    }

    public int[] getAnswer(List<Integer> result) {
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public void calculateTime(String[] records) {
        for (String record : records) {
            String[] recordArr = record.split(" ");
            int[] recordTimeArr = Arrays.stream(recordArr[0].split(":"))
                    .mapToInt(Integer::parseInt).toArray();
            int recordTime = getTime(recordTimeArr[0], recordTimeArr[1]);
            String carNumber = recordArr[1];
            boolean isCarIn = recordArr[2].equals("IN");

            recordsMap.put(carNumber, isCarIn ? recordsMap.getOrDefault(carNumber, 0) - recordTime
                    : recordsMap.getOrDefault(carNumber, 0) + recordTime);
        }

        recordsMap.replaceAll((key, value) -> value <= 0 ? value + LAST_TIME : value);
        // 23:59 출차 계산
    }

    public int getTime(int hour, int minute) {
        return hour * 60 + minute;
    }

    public void calculateFees() {
        List<String> keySet = new ArrayList<>(recordsMap.keySet());
        Collections.sort(keySet);

        for (String key : keySet) {
            int additionalTime = recordsMap.get(key);
            int additionalFee = 0;

            if (additionalTime > baseTime) {
                additionalFee = (int) (Math.ceil((double) (additionalTime - baseTime) / unitTime)
                        * feePerUnitTime);
            }

            result.add(baseFee + additionalFee);
        }
    }
}