package com.niit.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.JobDAO;
import com.coll.models.Job;

@RestController
public class JobRestController {

	@Autowired
	JobDAO jobDAO;

	/*@GetMapping(value = "/demo")*/
	public ResponseEntity<String> demo() {
		return new ResponseEntity<String>("Demo  page  successfully loaded...", HttpStatus.OK);
	}

	@PostMapping(value = "/addJob")
	public ResponseEntity<List<Job>> addJob(@RequestBody Job job, HttpSession session) {
		job.setCompanyName("manasi");
		job.setLocation("pune");
		if (jobDAO.addJob(job)) {
			return new ResponseEntity<List<Job>>(HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Job>>(HttpStatus.CONFLICT);
		}
	}

	@PostMapping(value = "/updatejob")
	public ResponseEntity<Job> updateJob(@RequestBody Job job, HttpStatus session) {
		job.getJobTitle();
		job.setCompanyName("Infosys");
		if (jobDAO.updateJob(job)) {
			return new ResponseEntity<Job>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Job>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(value = "/deletejob")
	public ResponseEntity<Job> deleteJob(@RequestBody Job jobid, HttpStatus session) {
		jobid.getId();
		if (jobDAO.deleteJob(jobid)) {
			return new ResponseEntity<Job>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Job>(HttpStatus.BAD_REQUEST);
		}

	}
}
