package com.niit.restcontroller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.BlogDAO;
import com.coll.models.Blog;

@RestController
public class BlogRestController {

	@Autowired
	BlogDAO blogDAO;

	/*public class DemoRestController {
		@GetMapping("/")
		public ResponseEntity<String> demoImpl() {
			System.out.println("--- Demo Restful API ---");
			return new ResponseEntity<String>("Welcome to Rest Controller", HttpStatus.OK);
		}
	}*/
		//---------------------------show all blogs--------------
	@GetMapping(value = "/showBlogs")
	public ResponseEntity<List<Blog>> showAllBlogs() {
		List<Blog> listBlogs = blogDAO.listBlogs();

		if (listBlogs.size() > 0)
			return new ResponseEntity<List<Blog>>(listBlogs, HttpStatus.OK);
		else
			return new ResponseEntity<List<Blog>>(listBlogs, HttpStatus.INTERNAL_SERVER_ERROR);

	}
	//-------------------------------------Adding blogs-------------------------------------

	@PostMapping(value = "/AddBlog")
	public ResponseEntity<String> addBlog(@RequestBody Blog blog) {
		blog.setDate(new Date());
		blog.setUsername("shubham");
		blog.setStatus("NA");
		if (blogDAO.addBlog(blog))
			return new ResponseEntity<String>("Blog Added", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);

	}
	//--------------------------------Approving blogs-----------------------------------

	@GetMapping(value = "/approveBlog/{blogid}")
	public ResponseEntity<String> approveBlog(@PathVariable("blogid") int blogid) {
		Blog blog = (Blog) blogDAO.getBlog(blogid);

		if (blogDAO.approveBlog(blog)) {
			return new ResponseEntity<String>("Approved", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
//-----------------------rejecting blog------------------------------------------------------
	@GetMapping(value = "/rejectBlog/{blogid}")
	public ResponseEntity<String> rejectBlog(@PathVariable("blogid") int blogid) {
		Blog blog = (Blog) blogDAO.getBlog(blogid);

		if (blogDAO.rejectBlog(blog)) {
			return new ResponseEntity<String>("Reject", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
//--------------------------------increment likes------------------------------------------
	@GetMapping(value = "/incrementLikes/{blogid}")
	public ResponseEntity<String> incrementLikes(@PathVariable("blogid") int blogid) {

		if (blogDAO.incrementLikes(blogid)) {
			return new ResponseEntity<String>("Incremented", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
//----------------------------------increment dislikes-------------------------------------
	@GetMapping(value = "/incrementDislikes/{blogid}")
	public ResponseEntity<String> decrementLikes(@PathVariable("blogid") int blogid) {

		if (blogDAO.incrementDislikes(blogid)) {
			return new ResponseEntity<String>("Increment Dislikes", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
