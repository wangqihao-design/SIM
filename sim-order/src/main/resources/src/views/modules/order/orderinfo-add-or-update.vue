<template>
  <el-dialog
      :title="!dataForm.orderId ? '新增' : '修改'"
      :close-on-click-modal="false"
      :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()"
             label-width="80px">
      <el-form-item label="price of the order" prop="orderPrice">
        <el-input v-model="dataForm.orderPrice" placeholder="price of the order"></el-input>
      </el-form-item>
      <el-form-item label="buyer's id" prop="receiverId">
        <el-input v-model="dataForm.receiverId" placeholder="buyer's id"></el-input>
      </el-form-item>
      <el-form-item label="seller's id" prop="producerId">
        <el-input v-model="dataForm.producerId" placeholder="seller's id"></el-input>
      </el-form-item>
      <el-form-item label="violation date" prop="vioDate">
        <el-input v-model="dataForm.vioDate" placeholder="violation date"></el-input>
      </el-form-item>
      <el-form-item label="violation cost
violation cost" prop="vioMoney">
        <el-input v-model="dataForm.vioMoney" placeholder="violation cost
violation cost"></el-input>
      </el-form-item>
      <el-form-item label="notes" prop="orderNote">
        <el-input v-model="dataForm.orderNote" placeholder="notes"></el-input>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
export default {
  data() {
    return {
      visible: false,
      dataForm: {
        orderId: 0,
        orderPrice: '',
        receiverId: '',
        producerId: '',
        vioDate: '',
        vioMoney: '',
        orderNote: ''
      },
      dataRule: {
        orderPrice: [
          {required: true, message: 'price of the order不能为空', trigger: 'blur'}
        ],
        receiverId: [
          {required: true, message: 'buyer's id不能为空', trigger: 'blur' }
        ],
        producerId: [
          {required: true, message: 'seller's id不能为空', trigger: 'blur' }
        ],
        vioDate: [
          {required: true, message: 'violation date不能为空', trigger: 'blur'}
        ],
        vioMoney: [
          {
            required: true, message: 'violation cost
            violation cost不能为空', trigger: 'blur' }
        ],
        orderNote: [
          {required: true, message: 'notes不能为空', trigger: 'blur'}
        ]
      }
    }
  },
    methods: {
      init(id)
      {
        this.dataForm.orderId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.orderId) {
            this.$http({
              url: this.$http.adornUrl(`/order/orderinfo/info/${this.dataForm.orderId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.orderPrice = data.orderinfo.orderPrice
                this.dataForm.receiverId = data.orderinfo.receiverId
                this.dataForm.producerId = data.orderinfo.producerId
                this.dataForm.vioDate = data.orderinfo.vioDate
                this.dataForm.vioMoney = data.orderinfo.vioMoney
                this.dataForm.orderNote = data.orderinfo.orderNote
              }
            })
          }
        })
      }
    ,
      // 表单提交
      dataFormSubmit()
      {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/order/orderinfo/${!this.dataForm.orderId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'orderId': this.dataForm.orderId || undefined,
                'orderPrice': this.dataForm.orderPrice,
                'receiverId': this.dataForm.receiverId,
                'producerId': this.dataForm.producerId,
                'vioDate': this.dataForm.vioDate,
                'vioMoney': this.dataForm.vioMoney,
                'orderNote': this.dataForm.orderNote
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
