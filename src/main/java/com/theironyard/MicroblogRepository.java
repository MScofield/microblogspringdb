package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by scofieldservices on 12/24/16.
 */
public interface MicroblogRepository extends CrudRepository <Message, Integer> {

}
