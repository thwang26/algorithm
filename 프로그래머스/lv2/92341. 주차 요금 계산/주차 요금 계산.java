import java.util.*;

class Solution {
    static int baseTime;
    static int baseFee;
    static int unitTime;
    static int feePerUnitTime;
    static final int LAST_TIME = 1439; // 23:59분을 분으로 계산
    Map<String, Integer> recordsMap = new HashMap<>();
    List<Integer> result = new ArrayList<>();

    public int[] solution(int[] fees, String[] records) {
        baseTime = fees[0];
        baseFee = fees[1];
        unitTime = fees[2];
        feePerUnitTime = fees[3];

        calculateTimes(records); // 주차시간 계산
        calculateFees(); // 주차시간에 따른 요금 계산

        return getAnswer(result);
    }

    public int[] getAnswer(List<Integer> result) {
        return result.stream().mapToInt(Integer::intValue).toArray();
    } // list -> int[]

    public void calculateTimes(String[] records) {
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
    } // 입,출차 정보로 map에 차량 별 주차시간 계산

    public int getTime(int hour, int minute) {
        return hour * 60 + minute;
    } // hh:mm -> 분으로 계산

    public void calculateFees() {
        List<String> keySet = new ArrayList<>(recordsMap.keySet());
        Collections.sort(keySet);

        for (String key : keySet) {
            int parkingTime = recordsMap.get(key);
            int additionalFee = 0;

            if (parkingTime > baseTime) {
                additionalFee = (int) (Math.ceil((double) (parkingTime - baseTime) / unitTime)
                        * feePerUnitTime);
            }

            result.add(baseFee + additionalFee);
        }
    } // map에 있는 차량별 주차시간에서 주차요금 계산
}