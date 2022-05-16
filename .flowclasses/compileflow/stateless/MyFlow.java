package compileflow.stateless;

import com.alibaba.compileflow.engine.common.utils.ObjectFactory;
import java.lang.Double;
import com.alibaba.compileflow.engine.process.preruntime.generator.bean.BeanProvider;
import com.alibaba.compileflow.engine.ProcessEngineFactory;
import java.util.Map;
import java.util.HashMap;
import com.alibaba.compileflow.engine.common.utils.DataType;
import com.alibaba.compileflow.engine.runtime.instance.ProcessInstance;
import java.lang.Math;

public class MyFlow implements ProcessInstance {

    private java.lang.Double num = null;
    private java.lang.Double numSqrt = null;

    public Map<String, Object> execute(Map<String, Object> _pContext) throws Exception {
        num = (Double)DataType.transfer(_pContext.get("num"), Double.class);
        Map<String, Object> _pResult = new HashMap<>();
        //AutoTaskNode: 计算平方根
        numSqrt = ((Math)ObjectFactory.getInstance("java.lang.Math")).sqrt(num);
        _pResult.put("numSqrt", numSqrt);
        return _pResult;
    }

}