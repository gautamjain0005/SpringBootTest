package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Worker;
import com.example.demo.repository.WorkerRepo;

@Component
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private WorkerRepo workerrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Worker w = workerrepo.findByName(username); 
		if(w==null)
		{
			throw new UsernameNotFoundException("User Not Found");
		}
		else
		{
			return new CustomUser(w);
		}
	}

}
