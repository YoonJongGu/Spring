<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<table>
	<thead>
		<tr>
			<th>카테고리</th>
			<th>기능</th>
			<th>요청(URL)</th>
			<th>요청(Method)</th>
			<th>Controller</th>
			<th>Controller Method</th>
			<th>Service</th>
			<th>DAO</th>
			<th>응답(Forward)</th>
			<th>응답(Redirect)</th>
		</tr>
	</thead>
	<tbody>		
		<tr>
			<td>-</td>
			<td>대문페이지</td>
			<td>/</td>
			<td>GET</td>
			<td>HomeController</td>
			<td>public String home()</td>
			<td>-</td>
			<td>-</td>
			<td>home</td>
			<td>-</td>
		</tr>
		<tr>
			<td>회원</td>
			<td>가입페이지</td>
			<td>/member/join</td>
			<td>GET</td>
			<td>MemberController</td>
			<td>public ModelAndView join()</td>
			<td>-</td>
			<td>select * from member5 order by idx</td>
			<td>join</td>
			<td>-</td>
		</tr>
		<tr>
			<td>회원</td>
			<td>가입페이지</td>
			<td>/member/join</td>
			<td>POST</td>
			<td>MemberController</td>
			<td>public String join(MemberDTO)</td>
			<td>-</td>
			<td>insert into member5 values (...)</td>
			<td>-</td>
			<td>redirect:/join</td>
		</tr>
		<tr>
			<td>회원</td>
			<td>로그인페이지</td>
			<td>/member/login</td>
			<td>GET</td>
			<td>MemberController</td>
			<td>public void login()</td>
			<td>-</td>
			<td>-</td>
			<td>login</td>
			<td>-</td>
		</tr>		
		<tr>
			<td>회원</td>
			<td>로그인페이지</td>
			<td>/member/login</td>
			<td>POST</td>
			<td>MemberController</td>
			<td>public ModelAndView login(MemberDTO dto)</td>
			<td>-</td>
			<td>select * from member5 where userid=? and userpw=?</td>
			<td>-</td>
			<td>redirect:/</td>
		</tr>
		<tr>
			<td>회원</td>
			<td>로그아웃페이지</td>
			<td>/member/logout</td>
			<td>GET</td>
			<td>MemberController</td>
			<td>public String logout()</td>
			<td>-</td>
			<td>-</td>
			<td>-</td>
			<td>redirect:/</td>
		</tr>
		<tr>
			<td>회원</td>
			<td>마이페이지</td>
			<td>/member/mypage/&#123;idx&#125;</td>
			<td>GET</td>
			<td>MemberController</td>
			<td>public ModelAndView mypage(int idx)</td>
			<td>-</td>
			<td>select * from member5 where idx=?</td>
			<td>mypage</td>
			<td>-</td>
		</tr>
		<tr>
			<td>회원</td>
			<td>수정페이지</td>
			<td>/member/modify/&#123;idx&#125;</td>
			<td>GET</td>
			<td>MemberController</td>
			<td>public ModelAndView modify(int idx)</td>
			<td>-</td>
			<td>select * from member5 where idx=?</td>
			<td>modify</td>
			<td>-</td>
		</tr>
		<tr>
			<td>회원</td>
			<td>수정페이지</td>
			<td>/member/modify</td>
			<td>POST</td>
			<td>MemberController</td>
			<td>public String modify(MemberDTO dto)</td>
			<td>-</td>
			<td>update member5 set (...)</td>
			<td>-</td>
			<td>redirect:/mypage + idx</td>
		</tr>
		<tr>
			<td>회원</td>
			<td>삭제페이지</td>
			<td>/member/delete/&#123;idx&#125;</td>
			<td>GET</td>
			<td>MemberController</td>
			<td>public String delete(int idx)</td>
			<td>-</td>
			<td>delete member5 where idx=?</td>
			<td>-</td>
			<td>redirect:/join</td>
		</tr>
		<tr>
			<td>게시판</td>
			<td>목록페이지</td>
			<td>/board/list</td>
			<td>GET</td>
			<td>BoardController</td>
			<td>public ModelAndView list()</td>
			<td>-</td>
			<td>select * from board order by idx</td>
			<td>list</td>
			<td>-</td>
		</tr>
		<tr>
			<td>게시판</td>
			<td>검색페이지</td>
			<td>/board/list</td>
			<td>POST</td>
			<td>BoardController</td>
			<td>public ModelAndView search(String keyword)</td>
			<td>-</td>
			<td>select * from board where title=? order by idx</td>
			<td>-</td>
			<td>redirect:/list</td>
		</tr>
		<tr>
			<td>게시판</td>
			<td>쓰기페이지</td>
			<td>/board/write</td>
			<td>GET</td>
			<td>BoardController</td>
			<td>public void write()</td>
			<td>-</td>
			<td>-</td>
			<td>write</td>
			<td>-</td>
		</tr>
		<tr>
			<td>게시판</td>
			<td>쓰기페이지</td>
			<td>/board/write</td>
			<td>POST</td>
			<td>BoardController</td>
			<td>public String write(BoardDTO dto)</td>
			<td>-</td>
			<td>insert into board values (...)</td>
			<td>-</td>
			<td>redirect:/list</td>
		</tr>
		<tr>
			<td>게시판</td>
			<td>상세페이지</td>
			<td>/board/detail/&#123;idx&#125;</td>
			<td>GET</td>
			<td>BoardController</td>
			<td>public ModelAndView detail(int idx)</td>
			<td>-</td>
			<td>select * from board where idx=?</td>
			<td>detail</td>
			<td>-</td>
		</tr>
		<tr>
			<td>게시판</td>
			<td>수정페이지</td>
			<td>/board/modify/&#123;idx&#125;</td>
			<td>GET</td>
			<td>BoardController</td>
			<td>public ModelAndView modify(int idx)</td>
			<td>-</td>
			<td>select * from board where idx=?</td>
			<td>modify</td>
			<td>-</td>
		</tr>
		<tr>
			<td>게시판</td>
			<td>수정페이지</td>
			<td>/board/modify</td>
			<td>POST</td>
			<td>BoardController</td>
			<td>public String modify(BoardDTO dto)</td>
			<td>-</td>
			<td>update board set (...)</td>
			<td>-</td>
			<td>redirect:/detail + idx</td>
		</tr>
		<tr>
			<td>게시판</td>
			<td>삭제페이지</td>
			<td>/board/delete/&#123;idx&#125;</td>
			<td>GET</td>
			<td>BoardController</td>
			<td>public String delete(int idx)</td>
			<td>-</td>
			<td>delete board where idx=?</td>
			<td>-</td>
			<td>redirect:/list</td>
		</tr>	
	</tbody>
</table>

</body>
</html>