# sh-papago

로그인 후 간단한 채팅 프로그램 사용<br>
번역기 <br>
번역한 로그 기록(게시판 페이징)<br>

### 사용 기술

```
springframework
ajax
websocket
lombok
mybatis
maria
```
### 구현

![login](https://user-images.githubusercontent.com/55867015/72411722-e8ee7400-37ae-11ea-806a-0ed57a92eee2.JPG)
#### 로그인 없이 다른 페이지로 접속할 경우 보여주는 에러 메시지
<img src="https://user-images.githubusercontent.com/55867015/72410551-f5250200-37ab-11ea-8b24-ec7c8d2a0a02.png" width="40%" height="40%"></img><br/>
#### 채팅방 접속
<img src="https://user-images.githubusercontent.com/55867015/72410558-fa824c80-37ab-11ea-91f7-889a400ba93c.png" width="40%" height="40%"></img><br/>
#### 번역기 접속
<img src="https://user-images.githubusercontent.com/55867015/72410561-fc4c1000-37ab-11ea-90bd-42885979310e.png" width="70%" height="70%"></img><br/>
#### 번역된 기록이 DB에 저장되고 로그에 기록
<img src="https://user-images.githubusercontent.com/55867015/72410564-fd7d3d00-37ab-11ea-83d4-76d6a13b0694.png" width="70%" height="70%"></img><br/>

### 구현 방법

```
ajax를 사용하여 MVC패턴을 사용하고 DBCP로 mariaDB에 접속한 뒤, mybatis를 사용 SQL문을 연결하여 번역기에서 번역한 로그를 DB에 저장
```

## Built With

* [springFramework](https://spring.io/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [bootstrap](http://bootstrapk.com/) - HTML, CSS framework
* [papago](https://developers.naver.com/docs/papago/) - translation api


