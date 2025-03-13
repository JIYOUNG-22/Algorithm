import java.io.*;
import java.util.*;

public class Main {
    static class Student implements Comparable<Student> {
        int num;
        int cnt;
        int timeStamp;

        public Student(int num, int cnt, int timeStamp) {
            this.num = num;
            this.cnt = cnt;
            this.timeStamp = timeStamp;
        }

        // 추천횟수 내림차순, 시간 내림차순 정렬 -> ArrayList 삭제 시간 단축을 위해
        @Override
        public int compareTo(Student s) {
            if(s.cnt - cnt == 0) {
                return s.timeStamp - timeStamp;
            }
            return s.cnt - cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());   // 사진틀의 개수
        int m = Integer.parseInt(br.readLine());     // 전체 추천 횟수

        List<Student> photos = new ArrayList<>();
        Student[] students = new Student[101];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 사진 추가
            if(students[num] != null) {
                students[num].cnt++;
            } else {
                Collections.sort(photos);

                if(photos.size() == n) {
                    // 사진 삭제
                    Student del = photos.remove(n - 1);
                    students[del.num] = null;
                }

                // 새로운 학생
                students[num] = new Student(num, 1, i);
                photos.add(students[num]);
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        Collections.sort(photos, (s1, s2) -> s1.num - s2.num);
        for(Student s : photos) {
            sb.append(s.num).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
