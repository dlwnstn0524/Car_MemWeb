package com.ssafy.test.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.ssafy.test.model.Car;
import com.ssafy.test.model.Member;
import com.ssafy.test.service.CarService;
import com.ssafy.test.service.CarServiceImpl;
import com.ssafy.test.service.MemberService;
import com.ssafy.test.service.MemberServiceImpl;

@WebServlet("/car")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarService cSer = CarServiceImpl.getInstance();
	private MemberService mSer = MemberServiceImpl.getInstance();

    public MyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			String url = "";
			if(action!=null) {
				if(action.equals("init")) {
					url = "/index.jsp";
				}else if(action.equals("list")) {
					url = list(request, response);
				} else if(action.equals("mvregist")) {
					url = "/car/regist.jsp";
				} else if(action.equals("regist")) {
					url = regist(request, response);
				} else if(action.equals("info")) {
					url = info(request, response);
				}  else if(action.equals("mvupdate")) {
					url = mvupdate(request, response);
				} else if(action.equals("delete")) {
					url = delete(request, response);
				} else if(action.equals("mvupdate")) {
					url = mvupdate(request, response);
				} else if(action.equals("update")) {
					url = update(request, response);
				} else if(action.equals("mvlogin")) {
					url = "/login.jsp";
				} else if(action.equals("logout")) {
					url = "logout";
				} else if(action.equals("mvlogin")) {
					url = login(request, response);
				}
			}
			request.getRequestDispatcher(url).forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private String login(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Member m = new Member(id, password);
		try {
			Member member = mSer.login(m);
			System.out.println(member);
			if (member != null) {
//				session 설정
				HttpSession session = request.getSession();
				session.setAttribute("userinfo", member);

//				cookie 설정
				String idsave = request.getParameter("remember");
				if ("ok".equals(idsave)) { // 아이디 저장을 체크 했다면.
					Cookie cookie = new Cookie("ssafy_id", id);
					cookie.setPath(request.getContextPath());
//					크롬의 경우 400일이 최대
//					https://developer.chrome.com/blog/cookie-max-age-expires/
					cookie.setMaxAge(60 * 60 * 24 * 365 * 40); // 40년간 저장.
					response.addCookie(cookie);
				} else { // 아이디 저장을 해제 했다면.
					Cookie cookies[] = request.getCookies();
					if (cookies != null) {
						for (Cookie cookie : cookies) {
							if ("ssafy_id".equals(cookie.getName())) {
								cookie.setMaxAge(0);
								response.addCookie(cookie);
								break;
							}
						}
					}
				}
				return "/car?action=init";
			} else {
				request.setAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요.");
				return "/login.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "/error.jsp";
		}
	}
	
	private String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
//		session.removeAttribute("userinfo");
		session.invalidate();
		return "";
	}


	private String update(HttpServletRequest request, HttpServletResponse response) {
		String number = request.getParameter("number");
		String model = request.getParameter("model");
		String price = request.getParameter("price");
		String brand = request.getParameter("brand");
		String size = request.getParameter("size");

		Car nCar = new Car(number, model, price, brand, size);
		try {
			cSer.update(nCar);
			return "/car?action=list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/error.jsp";
	}

	private String mvupdate(HttpServletRequest request, HttpServletResponse response) {
		String number = request.getParameter("number");
		Car detail;
		try {
			detail = cSer.getDetail(new Car(number));
			request.setAttribute("dto", detail);
			return "car/update.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error.jsp";
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		String number = request.getParameter("number");
		Car car = new Car(number);
		try {
			cSer.delete(car);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/car?action=list";
	}

	private String info(HttpServletRequest request, HttpServletResponse response) {
		String number = request.getParameter("number");
		Car detail;
		try {
			detail = cSer.getDetail(new Car(number));
			request.setAttribute("dto", detail);
			return "car/detail.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error.jsp";
	}

	private String regist(HttpServletRequest request, HttpServletResponse response) {
		String number = request.getParameter("number");
		String model = request.getParameter("model");
		String price = request.getParameter("price");
		String brand = request.getParameter("brand");
		String size = request.getParameter("size");

		Car nCar = new Car(number, model, price, brand, size);
		try {
			cSer.insert(nCar);
			return "/car?action=list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/error.jsp";
	}

	private String list(HttpServletRequest request, HttpServletResponse response) {
		List<Car> list;
		try {
			list = cSer.getCars();
			request.setAttribute("list", list);
			return "/car/list.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/error.jsp";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
