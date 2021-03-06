/*
 * Copyright 2016 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.storm.kafka.spout;

import org.apache.storm.tuple.Fields;
import org.junit.Assert;
import org.junit.Test;

public class KafkaSpoutStreamsNamedTopicsTest {

	@Test
	public void testGetOutputFields() {
		Fields outputFields = new Fields("b","a");
		String[] topics = new String[]{"testTopic"};
		String streamId = "test";
		KafkaSpoutStreamsNamedTopics build = new KafkaSpoutStreamsNamedTopics.Builder(outputFields, streamId, topics)
        .addStream(outputFields, streamId, topics)
        .build();
		Fields actualFields = build.getOutputFields();
		Assert.assertEquals(outputFields.get(0), actualFields.get(0));
		Assert.assertEquals(outputFields.get(1), actualFields.get(1));

	}

}
