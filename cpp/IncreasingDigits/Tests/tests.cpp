#include "stdafx.h"
#include "CppUnitTest.h"
#include "../IncreasingDigits/Source.cpp"

using namespace Microsoft::VisualStudio::CppUnitTestFramework;

namespace Tests {
	TEST_CLASS(tests) {
	public:
		
		TEST_METHOD(computeSmallest) {
      Assert::AreEqual(100, computeSmallestNumber(3));
    }

    TEST_METHOD(computeLargest) {
      Assert::AreEqual(999, computeLargestNumber(3));
    }

    TEST_METHOD(isIncreasingNumber_true) {
      Assert::IsTrue(isIncreasingNumber(1234));
    }

    TEST_METHOD(isIncreasingNumber_false) {
      Assert::IsFalse(isIncreasingNumber(4321));
    }
	};
}